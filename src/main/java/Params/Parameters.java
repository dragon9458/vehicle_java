package Params;

/**
 * 透视变换矩阵参数
 * @author dragon
 *
 */
public class Parameters {
	
	public static void main(String arg[]) {
		//Parameters param = Parameters.getInstance();
		System.out.println(Constants.base);
	}
	
	private static Parameters param = null;
	private static PropertiesLoader pl;
	
	private Parameters(Builder builder) {
		p1x = builder.p1x;
		p2x = builder.p2x; 
		p3x = builder.p3x;
		p4x = builder.p4x;
		p1y = builder.p1y;
		p2y = builder.p2y;
		p3y = builder.p3y;
		p4y = builder.p4y;
		base = builder.base;
		flag = builder.flag;
		release = builder.release;
	}
	
	/**
	 * 全局唯一：计划生育
	 * @return
	 */
	public static Parameters getInstance() {
		if(param == null) {
			param = new Builder()
					.flag(Constants.flag)
					.base(Constants.base)
					.p1x(Constants.p1x)
					.p1y(Constants.p1y)
					.p2x(Constants.p2x)
					.p2y(Constants.p2y)
					.p3x(Constants.p3x)
					.p3y(Constants.p3y)
					.p4x(Constants.p4x)
					.p4y(Constants.p4y)
					.build();
		}
		return param;
	}
	
	
	int p1x;
	int	p1y;
	int	p2x;
	int	p2y;
	int	p3x;
	int	p3y;
	int	p4x;
	int	p4y;
	int	base;
	int	flag; 
	int release;
		
	public int getP1x() {
		this.p1x = Constants.p1x;
		return p1x;
	}
	public int getP1y() {
		this.p1y = Constants.p1y;
		return p1y;
	}
	public int getP2x() {
		this.p2x = Constants.p2x;
		return p2x;
	}
	public int getP2y() {
		this.p2y = Constants.p2y;
		return p2y;
	}
	public int getP3x() {
		this.p3x = Constants.p3x;
		return p3x;
	}
	public int getP3y() {
		this.p3y = Constants.p3y;
		return p3y;
	}
	public int getP4x() {
		this.p4x = Constants.p4x;
		return p4x;
	}
	public int getP4y() {
		this.p4y = Constants.p4y;
		return p4y;
	}
	public int getBase() {
		this.base = Constants.base;
		return base;
	}
	public int getFlag() {
		this.flag = Constants.flag;
		return flag;
	}
	public int getRelease() {
		this.release = Constants.release;
		return release;
	}
	
	
	
	
	public void setP1x(int p1x) {
		pl.setString("p1x", String.valueOf(p1x));
		this.p1x = p1x;
	}
	public void setP1y(int p1y) {
		pl.setString("p1y", String.valueOf(p1y));
		this.p1y = p1y;
	}
	public void setP2x(int p2x) {
		pl.setString("p2x", String.valueOf(p2x));
		this.p2x = p2x;
	}
	public void setP2y(int p2y) {
		pl.setString("p2y", String.valueOf(p2y));
		this.p2y = p2y;
	}
	public void setP3x(int p3x) {
		pl.setString("p3x", String.valueOf(p3x));
		this.p3x = p3x;
	}
	public void setP3y(int p3y) {
		pl.setString("p3y", String.valueOf(p3y));
		this.p3y = p3y;
	}
	public void setP4x(int p4x) {
		pl.setString("p4x", String.valueOf(p4x));
		this.p4x = p4x;
	}
	public void setP4y(int p4y) {
		pl.setString("p4y", String.valueOf(p4y));
		this.p4y = p4y;
	}
	public void setBase(int base) {
		pl.setString("base", String.valueOf(base));
		this.base = base;
	}
	public void setFlag(int flag) {
		pl.setString("flag", String.valueOf(flag));
		this.flag = flag;
	}
	public void setRelease(int release) {
		pl.setString("release", String.valueOf(release));
		this.release = release;
	}
	
	public static class Builder {		
		private int p1x;
		private int	p1y;
		private int	p2x;
		private int	p2y;
		private int	p3x;
		private int	p3y;
		private int	p4x;
		private int	p4y;
		private int	base;
		private int	flag; 
		private int release;
		
		public Builder p1x(int val) {
			p1x = val;
			return this;
		}
		public Builder p1y(int val) {
			p1y = val;
			return this;
		}
		public Builder p2x(int val) {
			p2x = val;
			return this;
		}
		public Builder p2y(int val) {
			p2y = val;
			return this;
		}
		public Builder p3x(int val) {
			p3x = val;
			return this;
		}
		public Builder p3y(int val) {
			p3y = val;
			return this;
		}
		public Builder p4x(int val) {
			p4x = val;
			return this;
		}
		public Builder base(int val) {
			base = val;
			return this;
		}
		public Builder p4y(int val) {
			p4y = val;
			return this;
		}
		public Builder flag(int val) {
			flag = val;
			return this;
		}
		public Builder release(int val) {
			release = val;
			return this;
		}
		
		public Parameters build() {
			return new Parameters(this);
		}
		
	}
	
	

}
