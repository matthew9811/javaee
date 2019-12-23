package com.shengxi.compent.utils;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.ObjectUtils;

public class PageUtil {

    public static Pageable listPageable(Map<String, Object> params, String sortField) {
        Sort sort = listSort(params, sortField);
        return listPageable(params, sort);
    }

    public static Sort listSort(Map<String, Object> params, String sortField) {
        Sort sort = null;
        Object st = params.get("sort");
        if (!ObjectUtils.isEmpty(st)) {
            String order = params.get("order").toString();
            if ("desc".equals(order)) {
                sort = new Sort(Direction.DESC, sortField);
            } else {
                List orders;
                sort = new Sort(Direction.ASC, sortField);
            }
        } else {
            sort = new Sort(Direction.DESC, sortField);
        }
        return sort;
    }

    public static Pageable listPageable(Map<String, Object> params, Sort sort) {
        return PageRequest.of(Integer.valueOf((String) params.get("offset")) / Integer.valueOf((String) params.get("limit")),
                Integer.valueOf((String) params.get("limit")), sort);
    }
}
