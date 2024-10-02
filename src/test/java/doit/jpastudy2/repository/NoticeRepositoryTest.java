package doit.jpastudy_hw.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class NoticeTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void saveAndRetrieveNotice() {
        // 1. 새로운 Category 엔티티 생성 후 저장
        Category category = new Category("Sports");
        categoryRepository.save(category);

        // 2. 새로운 Notice 엔티티 생성 후 저장
        Notice notice = new Notice("John Doe", "Football Match", category);
        noticeRepository.save(notice);

        // 3. 저장된 Notice 엔티티 모두 조회
        List<Notice> notices = noticeRepository.findAll();

        // 4. Notice 엔티티가 잘 저장되었는지 확인
        assertEquals(1, notices.size());
        assertEquals("John Doe", notices.get(0).getWriter());
        assertEquals("Football Match", notices.get(0).getTitle());

        // 5. Notice와 연결된 Category 확인
        assertNotNull(notices.get(0).getCategory());
        assertEquals("Sports", notices.get(0).getCategory().getSubject());
    }
}
