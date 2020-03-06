package cn.hhj.course;

import cn.hhj.course.dao.AnnouncementMapper;
import cn.hhj.course.entity.Announcement;
import cn.hhj.course.service.AnnouncementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: SoFakeHuang
 * @Date: 2019/4/12 19:08
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Repository
public class TestAnnouncement {
    @Autowired
    AnnouncementMapper announcementMapper;

    @Autowired
    AnnouncementService announcementService;

    @Test
    public void add(){
        Announcement announcement = new Announcement();
        announcement.setText("test add announcement");
        announcement.setTittle("Test");
        announcementMapper.insert(announcement);
    }

}
