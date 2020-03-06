package cn.hhj.course.service.impl;

import cn.hhj.course.dao.GradeMapper;
import cn.hhj.course.dao.GradeModificationReviewMapper;
import cn.hhj.course.dao.UserMapper;
import cn.hhj.course.entity.Grade;
import cn.hhj.course.entity.GradeModificationReview;
import cn.hhj.course.service.GradeModificationReviewService;
import cn.hhj.course.vo.GradeEnterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/3/3 3:00
 * @Version 1.0
 */
@Service("gradeModificationReviewService")
public class GradeModificationReviewServiceImpl implements GradeModificationReviewService {

    @Autowired
    private GradeModificationReviewMapper gradeModificationReviewMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int pass(int id) {
        GradeModificationReview recod = new GradeModificationReview();
        recod.setId(id);
        //检验id是否存在
        List<GradeModificationReview> list = gradeModificationReviewMapper.select(recod);
        if(list.size()<=0){
            return 0;
        }
        //更新审核状态
        GradeModificationReview gradeModificationReview = list.get(0);
        gradeModificationReview.setStatus(1);
        gradeModificationReviewMapper.updateStatusById(gradeModificationReview);
        //修改成绩
        GradeEnterVo grade = new GradeEnterVo();
        grade.setGrade(gradeModificationReview.getGrade());
        grade.setTeacherCourseId(gradeModificationReview.getTeacherCourseId());
        grade.setUserId(userMapper.selectByAccount(gradeModificationReview.getAccount()).getId());
        gradeMapper.updateByUserIdCourseId(grade);
        return 1;
    }
}
