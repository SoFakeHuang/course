package cn.hhj.course.dao;

import cn.hhj.course.entity.Classes;
import cn.hhj.course.entity.ClassesExample;
import cn.hhj.course.entity.GradeModificationReview;
import cn.hhj.course.vo.GradeReviewVo;

import java.util.List;

public interface GradeModificationReviewMapper {
    int insert(GradeModificationReview gradeModificationReview);

    /**
     * 根据传入属性作为查询条件进行查询
     * @param gradeModificationReview
     * @return
     */
    List<GradeModificationReview> select(GradeModificationReview gradeModificationReview);

    /**
     * 根据传入属性作为查询条件进行查询Vo
     * @return
     */
    List<GradeReviewVo> selectGradeReviewVoList();

    /**
     * 根据id更新审核状态
     * @param gradeModificationReview
     * @return
     */
    int updateStatusById(GradeModificationReview gradeModificationReview);
}