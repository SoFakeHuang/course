package cn.hhj.course.controller;

import cn.hhj.course.BaseInfo;
import cn.hhj.course.ResponsResult;
import cn.hhj.course.dao.GradeModificationReviewMapper;
import cn.hhj.course.entity.GradeModificationReview;
import cn.hhj.course.entity.User;
import cn.hhj.course.service.GradeModificationReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/3/3 0:52
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/gradeReview")
public class GradeModificationReviewController extends BaseController{

    @Autowired
    private GradeModificationReviewMapper gradeModificationReviewMapper;

    @Autowired
    private GradeModificationReviewService gradeModificationReviewService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public ResponsResult<GradeModificationReview> insert(@RequestBody GradeModificationReview gradeModificationReview, HttpSession session){
        if(gradeModificationReview == null || gradeModificationReview.getGrade() == null){
            return failHandler("参数缺失");
        }

        User user = (User) session.getAttribute(BaseInfo.USER);
        gradeModificationReview.setUserId(user.getId());
        gradeModificationReview.setStatus(0);
        gradeModificationReviewMapper.insert(gradeModificationReview);

        return inbound(null,"申请提交成功");
    }

    @RequestMapping(value = "/pass")
    @ResponseBody
    public ResponsResult<GradeModificationReview> pass(@RequestBody Integer id){
        if(id == null){
            return failHandler("参数缺失");
        }
        gradeModificationReviewService.pass(id);

        return inbound(null,"通过成功");

    }

    @RequestMapping(value = "/fail")
    @ResponseBody
    public ResponsResult<GradeModificationReview> fail(@RequestBody Integer id){
        if(id == null){
            return failHandler("参数缺失");
        }
        GradeModificationReview gradeModificationReview = new GradeModificationReview();
        gradeModificationReview.setStatus(0);
        gradeModificationReview.setId(id);
        gradeModificationReviewMapper.updateStatusById(gradeModificationReview);
        return inbound(null,"不通过成功");

    }

}
