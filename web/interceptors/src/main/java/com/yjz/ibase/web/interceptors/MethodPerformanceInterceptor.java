package com.yjz.ibase.web.interceptors;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MethodPerformanceInterceptor
{
  private static final Logger LOG = Logger
      .getLogger(MethodPerformanceInterceptor.class.getCanonicalName());

  @AroundInvoke
  public Object intercept(final InvocationContext context) throws Exception
  {
    final String className = context.getTarget().toString();
    final String methodName = context.getMethod().getName();

    final Instant start = Instant.now();

    Object result = null;
    try
    {
      result = context.proceed();
    }
    finally
    {
      final Instant end = Instant.now();
      if (LOG.isLoggable(Level.FINEST))
      {
        LOG.finest(
            "### Total execution time of " + className + "::" + methodName
                + " is: " + Duration.between(start, end).toMillis() + " ms.");
      }
    }

    return result;
  }
}
