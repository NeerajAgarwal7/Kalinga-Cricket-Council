package com.mindtree.kcc.entity;

import java.util.Comparator;

public class AvgComparator implements Comparator<Object> {
	
	public int compare(Object arg0, Object arg1) {
		Player p1 = (Player) arg0;
		Player p2 = (Player) arg1;
		if (p1.getBattingAvg() < p2.getBattingAvg())
			return 1;
		else if (p1.getBattingAvg() > p2.getBattingAvg())
			return -1;
		else
			return 0;
	}

}
