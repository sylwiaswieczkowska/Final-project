package pl.sdacademy.finalproject.comment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public void saveComment(CommentDto commentDto){
        commentRepository.save(commentMapper.fromCommentDtoToCommentModel(commentDto));
    }

    public List<CommentDto> showAllComments(){
        return  null;
    }

    public Long deleteComment(Long id){
        return null;
    }

    public  CommentDto updateComment(CommentDto commentDto){
        return null;
    }

}
