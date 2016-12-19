package org.seckill.exception;

/**
 * repeat seckill exception(runtime exception)
 * @author xuyi
 *
 */
public class RepeatKillException extends SeckillException {

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatKillException(String message) {
		super(message);
	}

}
