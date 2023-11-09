package com.findbydema.domain.user.service;


import com.findbydema.domain.user.controller.dto.request.PatchUserRequest;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatchUserService {

    private final UserFacade facade;
    private final UserRepository repository;

    public void execute(PatchUserRequest request) {
        User user = facade.getInfo();

        if(!request.getEmail().isEmpty()) {
            user.setEmail(request.getEmail());
        }

        if(!request.getNickname().isEmpty()) {
            user.setNickname(request.getNickname());
        }

        if(!request.getImg().isEmpty()) {
            user.setImg(request.getImg());
        }

        repository.save(user);
    }



}
