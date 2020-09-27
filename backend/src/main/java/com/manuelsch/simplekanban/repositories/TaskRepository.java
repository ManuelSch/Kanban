package com.manuelsch.simplekanban.repositories;

import com.manuelsch.simplekanban.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides access to the Kanban tasks stored in the database
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
