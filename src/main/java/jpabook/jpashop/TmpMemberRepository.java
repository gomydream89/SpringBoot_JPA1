package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TmpMemberRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(TmpMember tmpMember) {
        em.persist(tmpMember);
        return tmpMember.getId();
    }

    public TmpMember find(Long id){
        return em.find(TmpMember.class, id);
    }
}
