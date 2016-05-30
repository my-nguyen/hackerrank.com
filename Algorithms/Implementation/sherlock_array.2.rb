# version 2: taking the sums (left and right) take too long and won't pass
# the submission tests #3 and #4 at hackerrank.com
require "benchmark"

def process(numbers)
  # puts("#{numbers}")
  if (numbers.length == 1)
    return "YES"
  elsif (numbers.length == 2)
    return "NO"
  else
    (1..numbers.length-2).each do |pivot|
      sum_left = numbers[0..pivot-1].inject(0) {|sum, i| sum + i }
      sum_right = numbers[pivot+1..numbers.length-1].inject(0) {|sum, i| sum + i }
      if sum_left == sum_right
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
