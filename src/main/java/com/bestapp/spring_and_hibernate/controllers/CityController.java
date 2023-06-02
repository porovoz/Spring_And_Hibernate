package com.bestapp.spring_and_hibernate.controllers;

import com.bestapp.spring_and_hibernate.model.City;
import com.bestapp.spring_and_hibernate.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@Tag(name = "Cities", description = "CRUD-operations to work with cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    @Operation(
            summary = "Create new city",
            description = "Create new city with its id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "City was successfully created",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Missing or incorrect format request parameters",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            )
    })
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.create(city);
        if (createdCity == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdCity);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find city by its id",
            description = "Search by city id"
    )
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "City was successfully found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "City not found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Missing or incorrect format request parameters",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            )
    })
    public ResponseEntity<City> readByIdCity(@PathVariable int id) {
        City city = cityService.readById(id);
        if (city == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(city);
    }

    @GetMapping
    @Operation(
            summary = "Find all cities",
            description = "Show all cities"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Cities were successfully found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cities were not found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Missing or incorrect format request parameters",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            )
    })
    public ResponseEntity<List<City>> readAllCity() {
        List<City> cities = cityService.readAll();
        if (cities == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cities);
    }


    @PutMapping
    @Operation(
            summary = "Update city by its id",
            description = "Search by city id to update it"
    )
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "City was successfully updated",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "City not found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Missing or incorrect format request parameters",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = City.class))
                            )
                    }
            )
    })
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        City updatedCity = cityService.updateCity(city);
        if (updatedCity == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete city by its id",
            description = "Search by city id to delete it"
    )
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "City was successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "City not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Missing or incorrect format request parameters"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<City> deleteCity(@RequestBody City city, @PathVariable int id) {
        City deletedCity = cityService.deleteCity(city, id);
        if (deletedCity == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedCity);
    }
}
