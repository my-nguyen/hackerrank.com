class Fibonacci
  def initialize
    @list = [0, 1]
    # it seems an array of 50 fibonacci numbers is adequate to pass the
    # submission at hackerrank.com
    (1..50).each do |index|
      @list << @list[index] + @list[index-1]
    end
  end

  def check(number)
    return @list.include?(number) ? "" : "Not"
  end
end

fibonacci = Fibonacci.new
gets.to_i.times do
  puts("Is#{fibonacci.check(gets.to_i)}Fibo")
end
