package com.johanes.tictactoe.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BoardSizeDto {

  @JsonProperty("size")
  private Integer size;

}
