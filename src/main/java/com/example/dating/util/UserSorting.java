package com.example.dating.util;

import java.util.Comparator;

import com.example.dating.dto.MatchUser;

public class UserSorting implements Comparator<MatchUser> {
	

	@Override
	public int compare(MatchUser o1, MatchUser o2) {
		if(o1.getAd()<o2.getAd()) {
			return -1;
		}else if(o1.getAd()>o2.getAd()) {
		return 1;
		}else {
			if(o1.getImc()<o2.getImc()) {
				return 1;
			}else {
				if(o1.getImc()>o2.getImc()) {
					return -1;
				}else {
					return 0;
				}
			}
		}
	}
}