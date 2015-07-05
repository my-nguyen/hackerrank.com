# Use instance variable to store square array, which may be efficient enough,
# since there's only one instantiation of Square
class Square
  def initialize
    @list = []
    # square numbers at the ready
    (1..100000).each do |number|
      @list << number*number
    end
  end

  # find the smallest square that is greater than or equal the number
  def equal(number)
    @list.each_index do |index|
      # with the list array containing square numbers that are so large, it is
      # guaranteed that a square will eventually be greater than given number
      if @list[index] >= number
        return index
      end
    end
  end

  # find the smallest square that is greater than the number
  def greater(number)
    @list.each_index do |index|
      if @list[index] > number
        return index
      end
    end
  end

  # return the number of squares between lower bound and upper bound, inclusive
  def count(bounds)
    return greater(bounds[1]) - equal(bounds[0])
  end
end

square = Square.new
gets.to_i.times do
  puts(square.count(gets.split.map{|i| i.to_i}))
end
