package it.techgap.challenge.java.senior;

public class Challenge02DesignPatterns {

	/**
	 * Synchronized Singleton class
	 */

	public static class Singleton {

		private static  Singleton IN = new Singleton();

		private Singleton() {
		}

		/**
		 * @return instance of the singleton
		 */
		public static Singleton getInstance() {

			if(IN == null){
				synchronized (Singleton.class) {
					if(IN == null){
						IN = new Singleton();
					}
				}
			}

			return IN;
		}



	}

}
