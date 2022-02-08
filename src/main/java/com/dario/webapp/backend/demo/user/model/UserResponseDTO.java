package com.dario.webapp.backend.demo.user.model;

import com.dario.webapp.backend.demo.user.type.StatusResponse;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO implements Serializable {

    private StatusResponse status;

    private User user;

}
