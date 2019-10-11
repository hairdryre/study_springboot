package com.zhoutianyu.learnspringboot.valid;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author zhoutianyu <tyzhou@wisedu.com>
 * @version 1.0.0
 * @date 2019/9/9 16:04
 */
@Data
public class Phone {

    @NotNull(message = "电话号码不能为空")
    private Long number;


    @Max(value = 5000, message = "预算价格不能超过{value}元")
    @Min(value = 1000, message = "价格预算不能低于{value}元")
    private double price;

    @NotBlank(message = "品牌不能为空")
	@Length(max = 5, message = "品牌长度不能超过{max}")
	private String brand;

}
