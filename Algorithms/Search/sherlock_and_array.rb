# version 4: calculate two moving sums, one to the left and one to the right of
# the moving pivot. As the pivot moves from left to right, the left sum is added
# the value at the point the pivot just left, and the right sum is subtracted
# the value at the point the pivot is moving to.
def process(numbers)
  if (numbers.length == 1)
    return "YES"
  elsif (numbers.length == 2)
    return "NO"
  else
    sum_left = numbers[0]
    sum_right = numbers[2..numbers.length-1].inject(0) {|sum, i| sum + i }
    (1..numbers.length-2).each do |pivot|
      if sum_left == sum_right
        return "YES"
      else
        sum_left += numbers[pivot]
        sum_right -= numbers[pivot+1]
      end
    end
    return "NO"
  end
end

gets.to_i.times do |j|
  gets
  puts(process(gets.split.map{|i| i.to_i}))
end
