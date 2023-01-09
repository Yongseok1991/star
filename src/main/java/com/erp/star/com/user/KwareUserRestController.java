package com.erp.star.com.user;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api")
@Slf4j
@Tag(name = "kwareRestController", description = "유저 컨트롤러")
@RequiredArgsConstructor
public class KwareUserRestController {

    private final KwareUserService service;

    @Operation(operationId = "getUser", summary = "유저 목록 조회", description = "유저 목록 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = KwareUserDTO.class)))),
    })
    @GetMapping("/list/{id}")
    @Parameters({
        @Parameter(name = "id", description = "유저 키", required = true)
    })
    public ResponseEntity<Optional> getUser(@PathVariable Long id) {
        log.info("KwareUserRestController::getUser(model, id)");
        Optional<KwareUser> user = service.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
