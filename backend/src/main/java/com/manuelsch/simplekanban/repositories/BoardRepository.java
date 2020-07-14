package com.manuelsch.simplekanban.repositories;

import com.manuelsch.simplekanban.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides access to the Kanban boards stored in the database
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

}
