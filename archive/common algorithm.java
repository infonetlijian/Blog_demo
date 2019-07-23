/** Sort Algorithm*/

  /**
     * Sorts/shuffles the given list according to the current sending queue
     * mode. The list can contain either Message or Tuple<Message, Connection>
     * objects. Other objects cause error.
     * @param list The list to sort or shuffle
     * @return The sorted/shuffled list
     */
    @Override
    @SuppressWarnings(value = "unchecked") /* ugly way to make this generic */
    protected List sortByQueueMode(List list) {
        switch (sendQueueMode) {
            case Q_MODE_RANDOM:
                Collections.shuffle(list, new Random(SimClock.getIntTime()));
                break;
            case Q_MODE_FIFO:
                /** warning: */
                /** modification method, FIFO according to message's name (e.g., M1, M2, M3...) */
                Collections.sort(list,
                        new Comparator() {
                            /** Compares two tuples by their messages' name */
                            public int compare(Object o1, Object o2) {
                                double diff;
                                Message m1, m2;

                                if (o1 instanceof Tuple) {
                                    m1 = ((Tuple<Message, Connection>)o1).getKey();
                                    m2 = ((Tuple<Message, Connection>)o2).getKey();
                                }
                                else if (o1 instanceof Message) {
                                    m1 = (Message)o1;
                                    m2 = (Message)o2;
                                }
                                else {
                                    throw new SimError("Invalid type of objects in " +
                                            "the list");
                                }

                                diff = resolveMessageID(m1) - resolveMessageID(m2);

                                if (diff == 0) {
                                    return 0;
                                }
                                return (diff < 0 ? -1 : 1);
                            }
                        });
                break;
            /* add more queue modes here */
            default:
                throw new SimError("Unknown queue mode " + sendQueueMode);
        }
        return list;
    }