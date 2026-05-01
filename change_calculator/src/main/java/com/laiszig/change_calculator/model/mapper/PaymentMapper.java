package com.laiszig.change_calculator.model.mapper;

import com.laiszig.change_calculator.model.BillUnit;
import com.laiszig.change_calculator.model.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentResponse toResponse(List<BillUnit> bills);
}
