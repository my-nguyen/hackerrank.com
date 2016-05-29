# version 2: use a static variable
class Square
  @@list = []
  def self.initialize
    # square numbers at the ready
    if @@list.empty?
      (1..100000).each do |number|
        @@list << number*number
      end
    end
  end

  def self.equal(number)
    initialize
    @@list.each_index do |index|
      if @@list[index] >= number
        return index
      end
    end
  end

  def self.greater(number)
    @@list.each_index do |index|
      if @@list[index] > number
        return index
      end
    end
  end

  def self.count(bounds)
    low = equal(bounds[0])
    high = greater(bounds[1])
    return high - low
  end
end

gets.strip.to_i.times do
  puts(Square.count(gets.split(" ").map(&:to_i)))
end
