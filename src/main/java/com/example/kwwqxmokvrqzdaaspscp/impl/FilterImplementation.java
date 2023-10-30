package com.example.kwwqxmokvrqzdaaspscp.impl;

import com.example.kwwqxmokvrqzdaaspscp.entity.Filter;
import org.springframework.data.domain.Sort;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

public class FilterImplementation implements Pageable {
    private final int limit;
    private final int offset;
    private Sort sort;
    public FilterImplementation(int offset, int limit, Sort sort) {
        if (offset < 0)
            throw new IllegalArgumentException("Offset must be positive!");

        if (limit < 0)
            throw new IllegalArgumentException("Limit must be > 0 !");
        this.offset = offset;
        this.limit = limit;

        if (sort != null) {
            this.sort = sort;
        }
    }
    public FilterImplementation(int offset, int limit){
        this(offset,limit, null);
    }
    @Override
    public int getNumberOfPages() {
        return 0;
    }

    @Override
    public PageFormat getPageFormat(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Printable getPrintable(int i) throws IndexOutOfBoundsException {
        return null;
    }
}
