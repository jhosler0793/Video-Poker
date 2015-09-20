public enum PayoutTier {
	TIER_1(1), TIER_2(2), TIER_3(3), TIER_4(4), TIER_5(5);
	
	private final int tier;
	
	private PayoutTier(int tier) {
		this.tier = tier;
	}

	public int getTier() {
		return this.tier;
	}
};