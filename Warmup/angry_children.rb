def angry_children(numbers, k)
  # sort the array of numbers so that given a range of k numbers, the followings
  # are readily available: min is at index 0, and max is at index+k-1
  numbers.sort!
  sum = 0
  (0..numbers.length-k).each do |i|
    # find the difference between the max and the min values of this range
    diff = numbers[i+k-1] - numbers[i]
    if (sum == 0) || (sum > diff)
      sum = diff
    end
  end
  return sum
end


total_n = gets.strip.to_i
subset_k = gets.strip.to_i
numbers = []
total_n.times do
  numbers << gets.strip.to_i
end
puts(angry_children(numbers, subset_k))
