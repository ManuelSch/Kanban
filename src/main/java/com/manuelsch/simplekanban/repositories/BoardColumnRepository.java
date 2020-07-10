package com.manuelsch.simplekanban.repositories;

import com.manuelsch.simplekanban.models.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides access to the Kanban board columns stored in the database
 */
@Repository
public interface BoardColumnRepository extends JpaRepository<BoardColumn, String> {
}
