# version 1: use instance variable to store square array, which may be efficient
# enough, since there's only one instantiation of Square
class Square
  def initialize
    # square numbers at the ready
    if @list == nil
      @list = []
      (1..100000).each do |number|
        @list << number*number
      end
    end
  end

  # find the smallest square that is >= the number
  def equal(number)
    @list.each_index do |index|
      # with the list array containing square numbers that are so large, it is
      # guaranteed that a square will eventually be greater than given number
      if @list[index] >= number
        return index
      end
    end
  end

  def greater(number)
    @list.each_index do |index|
      if @list[index] > number
        return index
      end
    end
  end

  # OLD WAY: look up each value between lower and bound in the list array
  # this method turned out to take too long when the bounds are in the 9-digits
  # which is the specs and also one of the test inputs from hackkerank.com.
  # so must change the way we look up square numbers
  def count(bounds)
    count = 0
    (bounds[0]..bounds[1]).each do |number|
      if list.include?(number)
        count += 1
      end
    end
end

square = Square.new
gets.strip.to_i.times do
  puts(square.count(gets.split(" ").map(&:to_i)))
end
