package cn.hhj.course.service;

/**
 * @Author: SoFakeHuang
 * @Date: 2020/3/3 2:57
 * @Version 1.0
 */
public interface GradeModificationReviewService {
    /**
     * 通过函数，更新审核状态为通过，并对成绩表进行更新
     * @param id
     * @return
     */
    int pass(int id);
}
