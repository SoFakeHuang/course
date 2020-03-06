package cn.hhj.course.rabbitmq;

import cn.hhj.course.dao.TeachersCourseMapper;
import cn.hhj.course.entity.Course;
import cn.hhj.course.entity.Grade;
import cn.hhj.course.entity.TeachersCourse;
import cn.hhj.course.service.ElectiveService;
import cn.hhj.course.service.TeachersCourseService;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: SoFakeHuang
 * @Date: 2019/7/5 3:33
 * @Version 1.0
 */
@Service
public class MQReceiver {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    TeachersCourseService teachersCourseService;

    @Autowired
    ElectiveService electiveService;


    /**
     * 接收选课队列
     * @param message；
     */
    @RabbitListener(queues = MQConfig.ELECTIVE_QUEUE)
    public void receive(String message){
        ElectiveMessage electiveMessage = stringToBean(message,ElectiveMessage.class);

        Integer userId = electiveMessage.getUserId();
        Integer teachersCourseId = electiveMessage.getCourseId();

        //判断课程库存
        TeachersCourse t = teachersCourseService.selectById(teachersCourseId);
        int count = t.getStudents_number();
        if(count<1){
            return;
        }

        Grade grade = new Grade();
        grade.setUser_id(userId);
        grade.setTeachers_course_id(teachersCourseId);

        electiveService.elective(grade);
    }

    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

}
