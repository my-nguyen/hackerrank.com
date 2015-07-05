def largest_decent(number)
  hash = Hash.new(0)
  found = false
  while true
    # first, look for a number divisible by 3 (as opposed to divisible by 5),
    # because we want to find as many 5's in the resulting string as possible
    # Note that this if condition allows for numbers such as 3 and 4 to be
    # evaluated before the elsif condition
    if number % 3 == 0
      # found a combination of 3's and 5's that add up to number
      hash[3] += number / 3
      found = true
      break
    elsif number >= 5
      number -= 5
      hash[5] += 1
    else
      break
    end
  end

  # construct the resulting string
  string = ""
  if found == false
    string = "-1"
  else
    hash[3].times do
      string << "555"
    end
    hash[5].times do
      string << "33333"
    end
  end

  return string
end

gets.to_i.times do
  puts(largest_decent(gets.to_i))
end
