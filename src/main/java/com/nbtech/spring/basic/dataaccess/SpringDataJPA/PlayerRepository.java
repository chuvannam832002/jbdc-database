package com.nbtech.spring.basic.dataaccess.SpringDataJPA;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public PlayerEntity insertPlayer(PlayerEntity player)
    {
        return entityManager.merge(player);
    }

    public PlayerEntity updatePlayer(PlayerEntity player)
    {
        return entityManager.merge(player);
    }

    public PlayerEntity getPlayerById(int id) {
        return entityManager.find(PlayerEntity.class, id);
    }
    public List<PlayerEntity> getAllPlayers() {
        TypedQuery<PlayerEntity> getAll = entityManager.createNamedQuery("get_all_players", PlayerEntity.class);
        return getAll.getResultList();
    }
    public void deleteById(int id){
        PlayerEntity player = entityManager.find(PlayerEntity.class, id);
        entityManager.remove(player);
    }
}


