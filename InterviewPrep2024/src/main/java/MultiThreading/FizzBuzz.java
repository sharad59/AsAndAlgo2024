package MultiThreading;

class FizzBuzz {
	private int n;
	private int i = 1;

	public FizzBuzz(int n) {
		this.n = n;
	}

	public void fizz() throws InterruptedException {
		while (i <= n) {
			synchronized (this) {
				while (!(i % 3 == 0 && i % 5 != 0) && i <= n)
					
					this.wait();
				if (i > n) {
					return;
				}
				System.out.print("fizz ");

				i++;
				this.notifyAll();

			}
		}
	}

	public void buzz() throws InterruptedException {
		while (i <= n) {
			synchronized (this) {
				while (!(i % 5 == 0 && i % 3 != 0) && i <= n)
					this.wait();
				if (i > n) {
					return;
				}

				System.out.print("buzz ");
				i++;
				this.notifyAll();

			}
		}
	}

	public void fizzbuzz() throws InterruptedException {
		while (i <= n) {
			synchronized (this) {
				while (!(i % 3 == 0 && i % 5 == 0) && i <= n)
					this.wait();
				if (i > n) {
					return;
				}

				System.out.print("fizzbuzz ");

				i++;
				this.notifyAll();

			}
		}
	}

	public void number() throws InterruptedException {
		while (i <= n) {
			synchronized (this) {
				while ((i % 3 == 0 || i % 5 == 0) && i <= n)
					this.wait();
				if (i > n) {
					return;
				}

				System.out.print(i + " ");

				i++;
				this.notifyAll();

			}
		}
	}
	
	public static void main(String args[]) {
		
		FizzBuzz fz= new FizzBuzz(5);
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					fz.buzz();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					fz.fizz();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t3 = new Thread() {
			@Override
			public void run() {
				try {
					fz.fizzbuzz();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t4 = new Thread() {
			@Override
			public void run() {
				try {
					fz.number();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	class abc{
		 public void fizz() throws InterruptedException {
		        synchronized (this) {
		            while (i<=n) {
		                if (i%3==0 && i%5!=0) {
		                   // printFizz.run();
		                    i+=1;
		                    notifyAll();            
		                } else {
		                    wait();
		                }
		            }
		        }
		    }

		    // printBuzz.run() outputs "buzz".
		    public void buzz() throws InterruptedException {
		        synchronized (this) {
		            while (i<=n) {
		                if (i%3!=0 && i%5==0) {
		                   // printBuzz.run();
		                    i+=1;
		                    notifyAll();            
		                } else {
		                    wait();
		                }
		            }
		        }
		    }

		    // printFizzBuzz.run() outputs "fizzbuzz".
		    public void fizzbuzz() throws InterruptedException {
		        synchronized (this) {
		            while (i<=n) {
		                if (i%15==0) {
		                   // printFizzBuzz.run();
		                    i+=1;
		                    notifyAll();            
		                } else {
		                    wait();
		                }
		            }
		        }
		    }

		    // printNumber.accept(x) outputs "x", where x is an integer.
		    public void number() throws InterruptedException {
		        synchronized (this) {
		            while (i<=n) {
		                if (i%3!=0 && i%5!=0) {
		                    //printNumber.accept(i);
		                    i+=1;
		                    notifyAll();            
		                } else {
		                    wait();
		                }
		            }
		        }
		    }
	}
}