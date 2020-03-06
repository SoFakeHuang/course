package cn.hhj.course.dao;

import cn.hhj.course.entity.Announcement;
import cn.hhj.course.entity.AnnouncementExample;
import cn.hhj.course.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnouncementMapper {
    int insert(Announcement record);

    int insertSelective(Announcement record);

    List<Announcement> selectByExampleWithBLOBs(AnnouncementExample example);

    List<Announcement> selectByExample(AnnouncementExample example);

    List<Announcement> selectAll( );

}