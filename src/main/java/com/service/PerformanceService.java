package com.service;

import com.model.Performance;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.time.ZonedDateTime;

/**
 * @author Ovidiu Lapusan
 */
@Service
public class PerformanceService {

	private final OperatingSystemMXBean operatingSystemMXBean;

	PerformanceService() {
		this.operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	}

	public Performance getPerformance() {
		Performance performance = new Performance();

		performance.setTime(ZonedDateTime.now().toInstant().toEpochMilli());

		performance.setCommittedVirtualMemorySize(operatingSystemMXBean.getCommittedVirtualMemorySize());

		performance.setTotalSwapSpaceSize(operatingSystemMXBean.getTotalSwapSpaceSize());
		performance.setFreeSwapSpaceSize(operatingSystemMXBean.getFreeSwapSpaceSize());

		performance.setTotalPhysicalMemorySize(operatingSystemMXBean.getTotalPhysicalMemorySize());
		performance.setFreePhysicalMemorySize(operatingSystemMXBean.getFreePhysicalMemorySize());

		performance.setSystemCpuLoad(operatingSystemMXBean.getSystemCpuLoad());
		performance.setProcessCpuLoad(operatingSystemMXBean.getProcessCpuLoad());

		return performance;
	}
}
