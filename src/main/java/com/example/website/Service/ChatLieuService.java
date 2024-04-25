package com.example.website.Service;

import com.example.website.Entity.ChatLieu;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.ChatLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ChatLieuService {

    @Autowired
    ChatLieuRepository chatLieuRepository;

    public List<ChatLieu> getListChatLieu() {
        return chatLieuRepository.findAll();
    }

    public ChatLieu findByID(UUID id) {
        return chatLieuRepository.findById(id).orElse(null);
    }

    public PageDTO<ChatLieu> getPageChatLieu(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(chatLieuRepository.findAllPageOrderByNgayNhapDesc(pageable));
    }

    public ChatLieu createChatLieu(ChatLieu chatLieu) {
        chatLieu.setNgay_them(LocalDateTime.now());
        return chatLieuRepository.save(chatLieu);
    }

    public ChatLieu updateChatLieu(ChatLieu chatLieu) {
        return chatLieuRepository.save(chatLieu);
    }

    public void deleteChatLieu(UUID id) {
        chatLieuRepository.deleteById(id);
    }
}
