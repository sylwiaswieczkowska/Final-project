package pl.sdacademy.finalproject.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
}
