package com.victorcode.restaurantprojectapirestfulspringboot.dtos;

import jakarta.validation.constraints.NotNull;


public record UserRecordDTO(@NotNull String userName, @NotNull String userEmail, @NotNull String userPassword) {
}
