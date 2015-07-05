# version 3: first attempt at optimization: using a pivot that moves from 1 to
# array.length-2. (1) When pivot is at left half, take the sum of all numbers to
# the left of the pivot, let's call it left-sum, then take the sum of all
# numbers to the right of the pivot, let's call it right-sum, while comparing it
# with the left-sum, once a right-sum exceeds a left-sum then break and move on
# This version still doesn't pass submission tests #3 and #4.
def sum_compare(array, low, high, compare)
  sum = 0
  (low..high).each do |i|
    sum += array[i]
    if sum > compare
      # puts("low: #{low}, high: #{high}, sum: #{sum}, compare: #{compare}")
      break
    end
  end
  # puts("low: #{low}, high: #{high}, compare: #{compare}, sum: #{sum}")
  return sum == compare
end

def process(numbers)
  # puts("#{numbers}")
  if (numbers.length == 1)
    return "YES"
  elsif (numbers.length == 2)
    return "NO"
  else
    half_way = numbers.length / 2
    # puts("half: #{half_way}")
    (1..half_way).each do |pivot|
      sum_left = numbers[0..pivot-1].inject(0) {|sum, i| sum + i }
      # puts("left::pivot: #{pivot}, sum#{numbers[0..pivot-1]} #{sum_left}")
      if sum_compare(numbers, pivot+1, numbers.length-1, sum_left)
        return "YES"
      end
    end
    (half_way+1..numbers.length-2).each do |pivot|
      sum_right = numbers[pivot+1..numbers.length-1].inject(0) {|sum, i| sum + i }
      # puts("right::pivot: #{pivot}, sum#{numbers[pivot+1..numbers.length-1]}: #{sum_right}")
      if sum_compare(numbers, 0, pivot-1, sum_right)
        return "YES"
      end
    end
    return "NO"
  end
end

gets.to_i.times do |j|
  # read and throw away this number
  gets
  puts(process(gets.split.map{|i| i.to_i}))
end
