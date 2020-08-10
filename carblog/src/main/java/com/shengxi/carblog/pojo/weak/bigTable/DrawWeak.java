package com.shengxi.carblog.pojo.weak.bigTable;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DrawWeak implements Serializable {
    private Integer id;
    private String img;
    private String title;
}
