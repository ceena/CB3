package mycloud;

import com.sun.xml.internal.bind.v2.TODO;

public class Guitar {
	
	//String variables to hold properties of the guitar
		private String serialNumber, builder, model, type, backWood, topWood; 
		
		//define another variable to store price of the guitar


		//no setter for serialNumber.once set in constructor. we cant change it
		//getter for serialNumber
		public String getSerialNumber(){
			return this.serialNumber;
		}


		/**
		 * @return the builder
		 */
		public String getBuilder() {
			return builder;
		}
		/**
		 * @param builder
		 *  the builder to set
		 */
		public void setBuilder(String builder) {
			this.builder = builder;
		}


		/**
		 * @return the model
		 */
		public String getModel() {
			return model;
		}/**
		 * @param model 
		 * the model to set
		 */
		public void setModel(String model) {
			this.model = model;
		}		


		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}
		/**
		 * @param type 
		 * the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
		

		/**
		 * @return the backWood
		 */
		public String getBackWood() {
			return backWood;
		}
		/**
		 * @param backWood 
		 * the backWood to set
		 */
		public void setBackWood(String backWood) {
			this.backWood = backWood;
		}


		/**
		 * @return the topWood
		 */
		public String getTopWood() {
			return topWood;
		}
		/**
		 * @param topWood
		 *  the topWood to set
		 */
		public void setTopWood(String topWood) {
			this.topWood = topWood;
		}		
		
		
		private void TODO() {
			// TODO Auto-generated method stub

		}

}
