package top.cantos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
public class ResultException extends RuntimeException {
	private String msg;
	private int code;
}
