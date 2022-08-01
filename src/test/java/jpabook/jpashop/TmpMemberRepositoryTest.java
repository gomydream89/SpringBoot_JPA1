package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmpMemberRepositoryTest {
    @Autowired
    TmpMemberRepository tmpMemberRepository;

    @Test
    @Transactional
    public void testMember(){
        TmpMember tmpMember = new TmpMember();
        tmpMember.setUsername("member A");
        Long savedId = tmpMemberRepository.save(tmpMember);

        TmpMember findTmpMember = tmpMemberRepository.find(savedId);
        assertThat(findTmpMember.getId()).isEqualTo(tmpMember.getId());
        assertThat(findTmpMember.getUsername()).isEqualTo(tmpMember.getUsername());
        assertThat(findTmpMember).isEqualTo(tmpMember);

    }

}
