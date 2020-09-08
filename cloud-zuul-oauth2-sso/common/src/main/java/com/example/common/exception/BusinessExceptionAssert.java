package com.example.common.exception;

import java.text.MessageFormat;

public interface BusinessExceptionAssert extends IResponseBase, Assert  {

	@Override
	default BaseException newException(Object... args) {
		String msg = MessageFormat.format(this.getMessage(), args);
		return new BusinessException(this, args, msg);
	}

	@Override
	default BaseException newException(Throwable t, Object... args) {
		String msg = MessageFormat.format(this.getMessage(), args);

		return new BusinessException(this, args, msg, t);
	}

}
