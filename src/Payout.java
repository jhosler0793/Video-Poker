public class Payout {	
	public static double getPayout(Hands h, double bet) {
		int payout = 0;
		
		if(bet < 101) {
			payout = h.getHandValue() * PayoutTier.TIER_1.getTier();
		}
		else if(bet < 201) {
			payout = h.getHandValue() * PayoutTier.TIER_2.getTier();
		}
		else if(bet < 301) {
			payout = h.getHandValue() * PayoutTier.TIER_3.getTier();
		}
		else if(bet < 401) {
			payout = h.getHandValue() * PayoutTier.TIER_4.getTier();
		}
		else if(bet < 501) {
			if(h == Hands.ROYAL_FLUSH) {
				payout = h.getHandValue() * 16;
			}
			else {
				payout = h.getHandValue() * PayoutTier.TIER_5.getTier();
			}
		}
		
		return payout * bet;
	}

	public static PayoutTier getPayTier(double bet) {
		if(bet < 101) {
			return PayoutTier.TIER_1;
		}
		else if(bet < 201) {
			return PayoutTier.TIER_2;
		}
		else if(bet < 301) {
			return PayoutTier.TIER_3;
		}
		else if(bet < 401) {
			return PayoutTier.TIER_4;
		}
		else {
			return PayoutTier.TIER_5;
		}
	}
}