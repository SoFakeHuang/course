package cn.hhj.course.service.impl;

import cn.hhj.course.dao.AnnouncementMapper;
import cn.hhj.course.entity.Announcement;
import cn.hhj.course.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: SoFakeHuang
 * @Date: 2019/4/12 19:03
 * @Version 1.0
 */
@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    public Integer add(Announcement announcement) {
        return announcementMapper.insert(announcement);
    }


}
