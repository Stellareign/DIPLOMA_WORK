package ru.skypro.homework.service.MapperUtil;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class CommentMapping {
    public CommentDTO mapToDto(Comment entity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPk(entity.getPk());
        commentDTO.setAuthor(entity.getAuthor().getId());
        commentDTO.setAuthorFirstName(entity.getAuthor().getFirstName());
        commentDTO.setAuthorImage(entity.getAuthor().getAvatarPath());
        commentDTO.setCreatedAt(Objects.requireNonNullElse(entity.getCreatedAt(), 0L));
        commentDTO.setText(entity.getText());

        return commentDTO;

    }

    public Comment mapToEntity(CreateOrUpdateCommentDTO createOrUpdateComment, User author, AdEntity ad) {
        Comment entity = new Comment();
        entity.setText(createOrUpdateComment.getText());
        entity.setAuthor(author);
        entity.setAdId(ad);
        entity.setCreatedAt(entity.getCreatedAt()); //<-- не могу понять, нужно ли здесь это???

        return  entity;
    }
}