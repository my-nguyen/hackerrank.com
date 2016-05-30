def count_divisible(string)
  count = 0
  value = string.to_i
  string.each_char do |char|
    digit = char.to_i
    # count the number of non-zero digits that is divisible by value
    if (digit != 0) && (value % digit == 0)
      count += 1
    end
  end
  return count
end

gets.to_i.times do
  puts(count_divisible(gets.strip))
end
